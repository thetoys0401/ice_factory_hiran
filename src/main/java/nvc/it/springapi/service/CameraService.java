package nvc.it.springapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.springapi.model.Camera;
import nvc.it.springapi.repository.CameraRepository;

@Service
public class CameraService {
    
    @Autowired
    private CameraRepository cameraRepository;

    public List<Camera> getCameras(){
        return cameraRepository.findAll();
    }
    public Optional<Camera> findById(String id){
        return cameraRepository.findById(id);
    }
    public List<Camera> findByCameraName(String name){
        return cameraRepository.findByNameContaining(name);
    }
    public Camera addCamera(Camera camera){
        return cameraRepository.save(camera);
    }
    public Optional<Camera> updateCamera(String id,Camera camera){
        Camera currenCamera = cameraRepository.findById(id).get();
        currenCamera.setName(camera.getName());
        currenCamera.setLocation(camera.getLocation());
        currenCamera.setAmount(camera.getAmount());
        return Optional.of(cameraRepository.save(currenCamera));
    }


}
