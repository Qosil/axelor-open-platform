package com.axelor.db;

import com.axelor.rpc.filter.Filter;

public interface JpaSecurity {
	
	static enum AccessType {
		
		READ	("You are not authorized to read this resource."),
		WRITE	("You are not authorized to update this resource."),
		CREATE	("You are not authorized to create this resource."),
		REMOVE	("You are not authrorized to remove this resource.");

		private String message;
		private AccessType(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return this.message;
		}
	}

	public static final AccessType CAN_READ = AccessType.READ;
	public static final AccessType CAN_WRITE = AccessType.WRITE;
	public static final AccessType CAN_CREATE = AccessType.CREATE;
	public static final AccessType CAN_REMOVE = AccessType.REMOVE;

	Filter getFilter(AccessType type, Class<? extends Model> model, Object... ids);

	void check(AccessType type, Class<? extends Model> model);

	void check(AccessType type, Class<? extends Model> model, Long id);
	
	void check(AccessType type, Model entity);
}
