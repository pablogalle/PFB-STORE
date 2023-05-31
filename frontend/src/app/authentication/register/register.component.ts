import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ValidationService } from '../services/validation.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{
attemptRegister() {
throw new Error('Method not implemented.');
}

  registerForm?: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private validationService: ValidationService){}

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
      confirmPassword: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
    },
    this.validationService.passwordMatch('password', 'confirmPassword')
    )
  }

  
}
