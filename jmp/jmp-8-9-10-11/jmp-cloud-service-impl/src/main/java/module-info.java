module org.caranus.jmp.cloud.service.impl {
	requires transitive org.caranus.jmp.service.api;
	requires org.caranus.jmp.dto;
	provides org.caranus.jmp.service.api.Service with org.caranus.jmp.cloud.service.impl.ServiceImpl;
	exports org.caranus.jmp.cloud.service.impl;
	exports org.caranus.jmp.cloud.service.exception;
}