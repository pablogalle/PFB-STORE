import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-identification',
  templateUrl: './identification.component.html',
  styleUrls: ['./identification.component.scss']
})
export class IdentificationComponent implements OnInit {

  loginForm?: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService) { }


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
    throw new Error('Method not implemented.');
  }
}
