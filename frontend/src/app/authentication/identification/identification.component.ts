import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { AuthenticationService } from '../services/authentication.service';
import { UserAuth } from '../model/UserAuth.model';
import { UserProfile } from '../model/UserProfile.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-identification',
  templateUrl: './identification.component.html',
  styleUrls: ['./identification.component.scss']
})
export class IdentificationComponent implements OnInit {

  loginForm?: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private authenticationService: AuthenticationService,
    private router: Router
    ) { }


  ngOnInit(): void {
    this.buildForm();
  }


  buildForm() {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      password: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]]
    })
  }

  logIn() {
    let userAuth = new UserAuth(this.loginForm!.get('username')!.value, this.loginForm!.get('password')!.value)
    this.authenticationService.authenticateUser(userAuth).subscribe(
      response => {
        if(response.status == 200) {
          let data = response.body!
          this.authenticationService.setUser(new UserProfile(data.username, data.name, data.apellidos, data.telephoneNumber, data.email, data.password, data.id, data.favouriteItemsIds))
          this.router.navigate(['/categories'])
        }
      },
      err => this.handleError(err)
    )
  }

  showErrorMessage(summary:string, detail: string) {
    this.messageService.add({ severity: 'error', summary: summary, detail: detail });
  }

  handleError(err: any): void {
    if(err.status == 401){
    this.showErrorMessage("Login incorrecto", "No existe ningun usuario con ese nombre o contraseña")
      
    }else this.showErrorMessage("Error inesperado", "Ha habido un error inesperado, intentalo de nuevo")    
  }
}


