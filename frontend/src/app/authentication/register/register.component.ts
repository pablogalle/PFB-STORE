import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ValidationService } from '../services/validation.service';
import { AuthenticationService } from '../services/authentication.service';
import { UserProfile } from '../model/UserProfile.model';
import { HttpStatusCode } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm?: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private authenticationService: AuthenticationService,
    private router: Router) {

  }

  ngOnInit(): void {
    this.loadForm()
  }

  loadForm() {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      surname: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      phoneNumber: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(100)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      confirmPassword: ['', [Validators.required]],
    },
      { validator: this.passwordMatchValidator }
    )
  }

  get confirmPasswordControl() {
    return this.registerForm!.get('confirmPassword');
  }

  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')!.value;
    const confirmPassword = formGroup.get('confirmPassword')!.value;

    if (password !== confirmPassword) {
      formGroup.get('confirmPassword')!.setErrors({ passwordMismatch: true });
    } else {
      formGroup.get('confirmPassword')!.setErrors(null);
    }
  }

  attemptRegister() {
    let userProfile = this.createFromForm()
    this.authenticationService.registerUser(userProfile).subscribe(
      response => {
        if(response.status == HttpStatusCode.Created){
          let data = response.body!
          this.authenticationService.setUser(new UserProfile(data.username, data.name, data.apellidos, data.telephoneNumber, data.email, data.password))
          this.router.navigate(['/categories']) 
        }
        else if(response.status == HttpStatusCode.Conflict) this.showErrorMessage("Usuario ya Existente", "Ya existe una cuenta con ese nombre de usuario")
        else this.showErrorMessage("Error inesperado", "Revisa los datos insertados e intentalo de nuevo")
      },
      err => console.log(err)
    )
  }

  createFromForm(): UserProfile {
    return {
      ...UserProfile,
      username: this.registerForm?.get(['username'])!.value,
      name: this.registerForm?.get(['name'])!.value,
      apellidos: this.registerForm?.get(['surname'])!.value,
      telephoneNumber: this.registerForm?.get(['phoneNumber'])!.value,
      email : this.registerForm?.get(['email'])!.value,
      password : this.registerForm?.get(['password'])!.value
    }
  }


  showErrorMessage(summary:string, detail: string) {
    this.messageService.add({ severity: 'error', summary: summary, detail: detail });
  }
}


