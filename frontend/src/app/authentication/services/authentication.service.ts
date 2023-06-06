import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuth } from '../model/UserAuth.model';
import { UserProfile } from '../model/UserProfile.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  userProfile?: UserProfile;

  constructor(private http: HttpClient) { }

  authenticateUser(userAuth: UserAuth) {
    let urlEndpoint: string = "http://localhost:8080/store/users/authenticate";
    return this.http.post<UserProfile>(urlEndpoint, userAuth, { observe: 'response' });
  }

  registerUser(userProfile: UserProfile) {
    let urlEndpoint: string = "http://localhost:8080/store/users/";
    return this.http.post<UserProfile>(urlEndpoint, userProfile, { observe: 'response' });
  }

  getUserByUsername(username: string) {
    let urlEndpoint: string = "http://localhost:8080/store/users/";
    return this.http.get<UserProfile>(urlEndpoint + username, { observe: 'response' });
  }

  addFavouriteItem(itemId: number){
    let urlEndpoint = "http://localhost:8080/store/users/"+this.userProfile!.id!+"/favourites/"+itemId
    return this.http.patch<UserProfile>(urlEndpoint, '')
  }




  setUser(userProfile: UserProfile) {
    this.userProfile = userProfile
    localStorage.setItem('username', userProfile.username)
  }

  asignUserFromPersistence() {
    if (localStorage.getItem('username')) {
      this.getUserByUsername(localStorage.getItem('username')!).subscribe(
        response => {
          let data = response.body!
          this.userProfile = new UserProfile(data.username, data.name, data.apellidos, data.telephoneNumber, data.email, data.password, data.id, data.favouriteItemsIds)
          console.log(this.userProfile)
        }
      )
    } else console.log("No user in persistence")
  }

  signOutUser() {
    localStorage.removeItem('username')
    this.userProfile = undefined
  }
}


