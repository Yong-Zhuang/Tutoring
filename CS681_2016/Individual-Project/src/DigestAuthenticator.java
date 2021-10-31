
public class DigestAuthenticator  implements  Authenticator{
    private final String realm;
    public DigestAuthenticator() {
		this.realm="Digest";
    }
    public boolean authenticate(HttpExchange httpExchange) {

    	//using MD5 decoding the userpass and then validate it. if pass, return new Authenticator.Success;
        String uname="test....."; 
        String pass ="test.....";
    	 if (checkCredentials (uname, pass)) {
             //return new Authenticator.Success (new HttpPrincipal (uname, realm));
    		 return true;
         } else {
//             Headers map = (Headers) t.getResponseHeaders();
//             map.set ("WWW-Authenticate", "Digest realm=" + "\""+realm+"\"");
             //return new Authenticator.Failure(401);
        	 return false;
         }
    }
	 private boolean checkCredentials(String uname, String pass)
	 {
		 //need to realise how to check uname and pass;
		 return true;
	 }
}