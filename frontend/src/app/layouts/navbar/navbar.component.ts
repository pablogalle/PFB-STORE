import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { UserProfile } from 'src/app/authentication/model/UserProfile.model';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  user?: UserProfile;

  constructor(
    private authService: AuthenticationService){}

  ngOnInit(): void {
    this.authService.asignUserFromPersistence()
  }

  isLoggedIn(){
    let user = this.authService.userProfile
    
    if(user ==  undefined) return false
    this.user = user
    return true
  }

  logOutUser(){
    this.authService.signOutUser()

  }
}
