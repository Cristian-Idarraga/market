package com.crcode.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.crcode.market.domain.Category;
import com.crcode.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	@Mappings({
		@Mapping(source = "idCategoria", target = "categoryId"),
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active")
	})
	Category toCategory(Categoria categoria);
	
	@InheritInverseConfiguration //Indica que es la inversa a la de arriba
	@Mapping(target = "productos", ignore = true) //Le decimos que que ignore ese atributo
	Categoria toCategoria(Category category);

}
