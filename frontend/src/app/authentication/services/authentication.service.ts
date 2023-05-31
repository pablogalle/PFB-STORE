import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuth } from '../model/UserAuth.model';
import { UserProfile } from '../model/UserProfile.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  userProfile? : UserProfile;

  constructor(private http: HttpClient) { }

  authenticateUser(userAuth : UserAuth){
    let urlEndpoint: string = "http://localhost:8080/store/users/authenticate";
    return this.http.post<UserProfile>(urlEndpoint, userAuth, {observe: 'response'});
  }

  setUser(userProfile: UserProfile){
    this.userProfile = userProfile
  }
  getUser() : UserProfile{
    return this.userProfile!
  }

  signOutUser(){
    this.userProfile = undefined
  }
}
