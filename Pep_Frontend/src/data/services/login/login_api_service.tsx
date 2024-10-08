import HttpClientWrapper from "../../api/http-client-wrapper";

class LoginApiService {
  private httpClientWrapper: HttpClientWrapper;

  constructor() {
    this.httpClientWrapper = new HttpClientWrapper();
  }
  async login(userCredentials: { email: string; password: string }): Promise<{ userId: string } | string> {
    try {
      const response = await this.httpClientWrapper.get("/api/v1/users");
      const users = response;
      // console.log('Users:', users);
      const user = users.find((u: any) => u.email === userCredentials.email);
      if (user) {
        if (user.password === userCredentials.password) {
          return { userId: user.id };
        } else {
          return "Incorrect password!";
        }
      } else {
        return "Invalid emailId!";
      }
    } catch (error) {
      console.error("Error:", error);
      return "An error occurred during login";
    }
  }

  async accessPermission(uid: string) : Promise<any>{
    try {
      const response = await this.httpClientWrapper.get(`/api/v1/accessPermission?uid=${uid}`);
      // console.log("accessPermission", response);
      return response;
    } catch (error) {
      console.error("Error fetching accessPermission:", error);
      throw error;
    }
  }

}

export default LoginApiService;
