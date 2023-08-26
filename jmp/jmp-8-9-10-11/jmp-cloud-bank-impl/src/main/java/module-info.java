module org.caranus.jmp.cloud.bank.impl {
	requires transitive org.caranus.jmp.bank.api;
	requires transitive org.caranus.jmp.dao;
	requires org.caranus.jmp.dto;
	exports org.caranus.jmp.cloud.bank.impl;
}