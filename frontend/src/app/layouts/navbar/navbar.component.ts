import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { UserProfile } from 'src/app/authentication/model/UserProfile.model';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  user?: UserProfile;

  constructor(
    private authService: AuthenticationService){}

  isLoggedIn(){
    let user = this.authService.getUser()

    if(user ==  undefined) return false
    this.user = user
    return true
  }

  logOutUser(){
    this.authService.signOutUser()

  }
}
