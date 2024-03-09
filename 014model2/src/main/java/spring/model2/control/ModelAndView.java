package spring.model2.control;

public class ModelAndView {
	
	private String viewName;
	private String modelName;
	private Object modelObject;
	
	public ModelAndView() {
	}
	
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	
	public ModelAndView(String viewName, String modelName, Object modelObject) {
		super();
		this.viewName = viewName;
		this.modelName = modelName;
		this.modelObject = modelObject;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Object getModelObject() {
		return modelObject;
	}

	public void setModelObject(Object modelObject) {
		this.modelObject = modelObject;
	}
	
	
	
}
