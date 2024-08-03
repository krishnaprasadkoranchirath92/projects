import axios from "axios";
const API_URL = "http://localhost:8080";

class UserService {
    saveUser(user) {
        console.log(user);
        // return axios.post(API_URL + "/saveUser", user);
        return axios({
            method: 'POST',
            url: API_URL + '/saveUser',
            headers:{
              'Content-Type':'application/json'
            },
            data: user,
          }).catch(function(err){
            console.log(err);
          });
    }
}

export default new UserService