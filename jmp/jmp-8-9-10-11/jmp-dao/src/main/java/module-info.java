module org.caranus.jmp.dao {
	requires org.caranus.jmp.dto;
	requires java.sql;
	exports org.caranus.jmp.dao;
	exports org.caranus.jmp.dao.impl;
}