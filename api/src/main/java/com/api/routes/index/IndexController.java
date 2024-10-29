package com.api.routes.index;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.api.routes.index.model.DocumentTypesModel;
import com.api.routes.index.model.ProductCategoriesModel;
import com.api.routes.index.model.RoleTypesModel;
import com.api.routes.index.model.TransactionTypesModel;
import com.api.routes.index.model.ViewsModel;

@RestController
@RequestMapping("index")
@Tag(name = "Index", description = "Endpoints para obtener la información de las tablas complemento de las principales.")
public class IndexController {
  @Autowired
  private IndexService indexService;

  @GetMapping("find-views")
  @Operation(summary = "Buscar todas las vistas.", description = "Retorna las vistas encontradas.")
  public List<ViewsModel> findAllViews() {
    return indexService.findAllViews();
  }

  @GetMapping("find-documentTypes")
  @Operation(summary = "Buscar todos los tipos de documentos.", description = "Retorna los tipos de documentos encontrados.")
  public List<DocumentTypesModel> findAllDocumentTypes() {
    return indexService.findAllDocumentTypes();
  }

  @GetMapping("find-productCategories")
  @Operation(summary = "Buscar todas las categorías de productos.", description = "Retorna las categorías de productos encontradas.")
  public List<ProductCategoriesModel> findAllProductCategories() {
    return indexService.findAllProductCategories();
  }

  @GetMapping("find-roleTypes")
  @Operation(summary = "Buscar todos los tipos de roles.", description = "Retorna los tipos de roles encontrados.")
  public List<RoleTypesModel> findAllRoleTypes() {
    return indexService.findAllRoleTypes();
  }

  @GetMapping("find-transactionTypes")
  @Operation(summary = "Buscar todos los tipos de transacciones.", description = "Retorna los tipos de transacciones encontrados.")
  public List<TransactionTypesModel> findAllTransactionTypes() {
    return indexService.findAllTransactionTypes();
  }
}
