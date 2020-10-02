
package pe.upc.bcp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.bcp.entity.NotificationCategory;
import pe.upc.bcp.repository.NotificationCategoryRepository;
import pe.upc.bcp.resource.NotificationCategoryResource;
import pe.upc.bcp.resource.NotificationResource;
import pe.upc.bcp.resource.SaveNotificationCategoryResource;
import pe.upc.bcp.service.NotificationCategoryService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "notificationcategories", description = "NotificationCategory API")
@RestController
@CrossOrigin
@RequestMapping(value ="/notificationcategory")
public class NotificationCategoryController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private NotificationCategoryService notificationcategoryService;

    @GetMapping("/notificationcategory")
    public org.springframework.data.domain.Page<NotificationCategoryResource> getAllNotificationCategorys(org.springframework.data.domain.Pageable pageable){
        List<NotificationCategoryResource> notificationcategory = notificationcategoryService.getAllNotificationCategories(
                pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int notificationcategoriesCount = notificationcategory.size();
        return new PageImpl<>(notificationcategory, pageable, notificationcategoriesCount);
    }

    @GetMapping("/notificationcategories/{id}")
    public NotificationCategoryResource getNotificationCategoryById(@PathVariable(name = "id") Long notificationcategoryId) {
        return convertToResource(notificationcategoryService.getNotificationCategoryById(notificationcategoryId));
    }

    @PostMapping("/notificationcategory")
    public NotificationCategoryResource createNotificationCategory(@Valid @RequestBody SaveNotificationCategoryResource resource) {
        return convertToResource(notificationcategoryService.createNotificationCategory(convertToEntity(resource)));
    }

    @PutMapping("/notificationcategories/{id}")
    public NotificationCategoryResource updateNotificationCategory(@PathVariable(name = "id") Long notificationcategoryId, @Valid @RequestBody SaveNotificationCategoryResource resource) {
        return convertToResource(notificationcategoryService.updateNotificationCategory(notificationcategoryId, convertToEntity(resource)));
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> deleteNotificationCategory(@PathVariable(name = "id") Long notificationcategoryId) {
        return notificationcategoryService.deleteNotificationCategory(notificationcategoryId);
    }

    private NotificationCategory convertToEntity(SaveNotificationCategoryResource resource)
    {
        return  mapper.map(resource, NotificationCategory.class);
    }

    private NotificationCategoryResource convertToResource(NotificationCategory entity)
    {
        return mapper.map(entity, NotificationCategoryResource.class);
    }
}
