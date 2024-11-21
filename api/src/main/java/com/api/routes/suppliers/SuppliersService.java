package com.api.routes.suppliers;

import java.util.List;
import java.sql.PreparedStatement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.api.routes.shared.utils.query.Binds;
import com.api.routes.suppliers.builder.SupplierBuilder;
import com.api.routes.suppliers.dto.CreateSupplierDto;
import com.api.routes.suppliers.dto.GetSupplierDto;
import com.api.routes.suppliers.dto.UpdateSupplierDto;
import com.api.routes.suppliers.model.SupplierModel;
import com.api.routes.suppliers.sql.SupplierSql;

@Service
public class SuppliersService extends SupplierBuilder {

  /**
   * Finds a supplier based on the provided supplier details.
   *
   * @param getSupplierDto the DTO containing the supplier details to search for
   * @return the found SupplierModel
   * @throws RuntimeException if an unexpected error occurs during the query
   */
  public List<SupplierModel> findSupplier(GetSupplierDto getSupplierDto) {
    SupplierModel supplier = new SupplierModel()
        .setName(getSupplierDto.getName())
        .setAddress(getSupplierDto.getAddress())
        .setPhone(getSupplierDto.getPhone())
        .build();

    Binds binds = buildFindSupplier(supplier);
    try {
      List<SupplierModel> supplierFound = jdbcTemplate.query(binds.getSql(), supplierRowMapper, binds.getParams());
      return supplierFound;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves a list of all suppliers from the database.
   *
   * @return a list of SupplierModel objects representing all suppliers.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<SupplierModel> findAllSuppliers() {
    try {
      List<SupplierModel> suppliers = jdbcTemplate.query(SupplierSql.FIND_ALL_SUPPLIERS.getQuery(), supplierRowMapper);
      return suppliers;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Creates a new supplier using the provided CreateSupplierDto.
   *
   * @param createSupplierDto the data transfer object containing the details of
   *                          the supplier to be created
   * @return the created SupplierModel with the generated ID
   * @throws RuntimeException if an unexpected error occurs during the creation
   *                          process
   */
  public SupplierModel createSupplier(CreateSupplierDto createSupplierDto) {
    SupplierModel supplier = new SupplierModel()
        .setName(createSupplierDto.getName())
        .setAddress(createSupplierDto.getAddress())
        .setPhone(createSupplierDto.getPhone())
        .build();

    Binds binds = buildCreateSupplier(supplier);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    try {
      jdbcTemplate.update(connection -> {
        PreparedStatement statement = connection.prepareStatement(binds.getSql(), new String[] { "id" });
        for (int i = 0; i < binds.getParams().length; i++) {
          statement.setObject(i + 1, binds.getParams()[i]);
        }
        return statement;
      }, keyHolder);

      @SuppressWarnings("null")
      int generatedId = keyHolder.getKey().intValue();
      return findSupplierById(generatedId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Updates the details of an existing supplier.
   *
   * @param updateSupplierDto the supplier to update
   * @return the updated SupplierModel
   * @throws RuntimeException if an unexpected error occurs during the update
   *                          process
   */
  public SupplierModel updateSupplier(UpdateSupplierDto updateSupplierDto, int supplierId) {
    SupplierModel supplier = new SupplierModel()
        .setName(updateSupplierDto.getName())
        .setAddress(updateSupplierDto.getAddress())
        .setPhone(updateSupplierDto.getPhone())
        .build();

    Binds binds = buildUpdateSupplier(supplier, supplierId);
    try {
      jdbcTemplate.update(binds.getSql(), binds.getParams());
      return findSupplierById(supplierId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Activates a supplier by updating its status in the database.
   *
   * @param supplierId the ID of the supplier to be activated
   * @return the ID of the activated supplier
   * @throws RuntimeException if an unexpected error occurs during the update
   */
  public int activateSupplier(int supplierId) {
    try {
      jdbcTemplate.update(SupplierSql.ACTIVE_SUPPLIER.getQuery(), supplierId);
      return supplierId;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Deletes a supplier from the database based on the provided supplier ID.
   *
   * @param supplierId the ID of the supplier to be deleted
   * @return the ID of the deleted supplier
   * @throws RuntimeException if an unexpected error occurs during the deletion
   *                          process
   */
  public int deleteSupplier(int supplierId) {
    try {
      jdbcTemplate.update(SupplierSql.DELETE_SUPPLIER.getQuery(), supplierId);
      return supplierId;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }
}
