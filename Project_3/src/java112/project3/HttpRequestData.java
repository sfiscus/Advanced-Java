package java112.project3;

/**
 * This is a JavaBean for project 3
 *
 *@author    Sean Fiscus
 */
public class HttpRequestData extends java.lang.Object {
 
    // Instance variables for the JavaBean for project 3
    private String remoteComputer;
    private String remoteComputerAddress;
    private String requestMethod;
    private String requestURI;
    private String requestURL;
    private String requestProtocol;
    private String serverName;
    private int serverPort;
    private String serverLocation;
    private String queryString;
    private String queryParameter;
    private String userAgent;
    
    
     
    /**
     *  Constructor for the HttpRequestData object
     */
    public HttpRequestData() { 
        
    }
    
    
	/**
	 * Returns the value of remoteComputer.
	 */
	public String getRemoteComputer() {
		
		return remoteComputer;
	}


	/**
	 * Sets the value of remoteComputer.
	 * @param remoteComputer The value to assign remoteComputer.
	 */
	public void setRemoteComputer(String remoteComputer) {
		this.remoteComputer = remoteComputer;
	}


	/**
	 * Returns the value of remoteComputerAddress.
	 */
	public String getRemoteComputerAddress() {
		return remoteComputerAddress;
	}


	/**
	 * Sets the value of remoteComputerAddress.
	 * @param remoteComputerAddress The value to assign remoteComputerAddress.
	 */
	public void setRemoteComputerAddress(String remoteComputerAddress) {
		this.remoteComputerAddress = remoteComputerAddress;
	}


	/**
	 * Returns the value of requestMethod.
	 */
	public String getRequestMethod() {
		return requestMethod;
	}


	/**
	 * Sets the value of requestMethod.
	 * @param requestMethod The value to assign requestMethod.
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}


	/**
	 * Returns the value of requestURI.
	 */
	public String getRequestURI() {
		return requestURI;
	}


	/**
	 * Sets the value of requestURI.
	 * @param requestURI The value to assign requestURI.
	 */
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}


	/**
	 * Returns the value of requestURL.
	 */
	public String getRequestURL() {
		return requestURL;
	}


	/**
	 * Sets the value of requestURL.
	 * @param requestURL The value to assign requestURL.
	 */
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}


	/**
	 * Returns the value of requestProtocol.
	 */
	public String getRequestProtocol() {
		return requestProtocol;
	}


	/**
	 * Sets the value of requestProtocol.
	 * @param requestProtocol The value to assign requestProtocol.
	 */
	public void setRequestProtocol(String requestProtocol) {
		this.requestProtocol = requestProtocol;
	}


	/**
	 * Returns the value of serverName.
	 */
	public String getServerName() {
		return serverName;
	}


	/**
	 * Sets the value of serverName.
	 * @param serverName The value to assign serverName.
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}


	/**
	 * Returns the value of serverPort.
	 */
	public int getServerPort() {
		return serverPort;
	}


	/**
	 * Sets the value of serverPort.
	 * @param serverPort The value to assign serverPort.
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}


	/**
	 * Returns the value of serverLocation.
	 */
	public String getServerLocation() {
		return serverLocation;
	}


	/**
	 * Sets the value of serverLocation.
	 * @param serverLocation The value to assign serverLocation.
	 */
	public void setServerLocation(String serverLocation) {
		this.serverLocation = serverLocation;
	}


	/**
	 * Returns the value of queryString.
	 */
	public String getQueryString() {
		return queryString;
	}


	/**
	 * Sets the value of queryString.
	 * @param queryString The value to assign queryString.
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}


	/**
	 * Returns the value of queryParameter.
	 */
	public String getQueryParameter() {
		return queryParameter;
	}


	/**
	 * Sets the value of queryParameter.
	 * @param queryParameter The value to assign queryParameter.
	 */
	public void setQueryParameter(String queryParameter) {
		this.queryParameter = queryParameter;
	}


	/**
	 * Returns the value of userAgent.
	 */
	public String getUserAgent() {
		return userAgent;
	}


	/**
	 * Sets the value of userAgent.
	 * @param userAgent The value to assign userAgent.
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
    
}
