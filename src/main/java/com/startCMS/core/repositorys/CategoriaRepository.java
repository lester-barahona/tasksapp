// package com.startCMS.core.repositorys;

// import java.awt.print.Pageable;
// import java.util.List;
// import java.util.Optional;


// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
// import org.springframework.stereotype.Repository;

/*
@Repository
public class CategoriaRepository implements CrudRepository<Categoria>{

	//to use logs
	private static final Logger log= LoggerFactory.getLogger(CategoriaRepository.class);
// @Autowired , use when no final propertie
	//(Dependency injection) can use autowired but is recommended like this
	protected final JdbcTemplate jdbcTemplate;

	public CategoriaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//we can also declare the row mapper
	RowMapper<Categoria> rowMapper=(resultSet,rowNum)->{
		Categoria cat=new Categoria();
		cat.setId(resultSet.getInt("ID"));
		cat.setNombre(resultSet.getString("NOMBRE"));
		cat.setDescripcion(resultSet.getString("DESCRIPCION"));
		cat.setCategoriaSuperior(resultSet.getInt("CATEGORIASUPERIOR"));
		return cat;
	};

	@Override
	public boolean save(Categoria categoria) {

			boolean success;

			int affectRows=jdbcTemplate.update(
					"insert into categorias (nombre,descripcion,categoriaSuperior) values (?,?,?)",
					categoria.getNombre(),categoria.getDescripcion(),categoria.getCategoriaSuperior()
					);

			if ( success=(affectRows==1)){
				log.info("Category insert success name:"+categoria.getNombre());
			}

			return success;
	}

	@Override
	public boolean update(Categoria categoria, Integer id) {

		boolean success;

		int affectRows=jdbcTemplate.update(
				"update categorias set nombre=?, descripcion=?, fecha=?, categoriaSuperior=?",
				categoria.getNombre(),categoria.getDescripcion(),categoria.getFecha(),categoria.getCategoriaSuperior()
		);

		if ( success=(affectRows==1)){
			log.info("Category updated success name:"+categoria.getNombre());
		}

		return success;
	}

	@Override
	public boolean deleteById(Integer id) {

		return false;
	}

	@Override
	public List<Categoria> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from categorias",rowMapper);
	}


	@Override
	public Optional<Categoria> findById(Integer id) {
		
		Categoria categoria=null;

		try {
			 categoria = jdbcTemplate.queryForObject(
					 "SELECT * FROM CATEGORIAS WHERE ID = ?", new CategoriaRowMapper(), new Object[] { id});
		} catch (Exception e) {

			log.error("Category not found with id:"+id);
		}

		return Optional.ofNullable(categoria);
	}

}
 */