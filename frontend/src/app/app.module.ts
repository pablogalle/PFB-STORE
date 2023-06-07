import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { CategoryListComponent } from './entities/category/category-list/category-list.component';
import { CategoryFormComponent } from './entities/category/category-form/category-form.component';
import { ItemListComponent } from './entities/item/item-list/item-list.component';
import { ItemFormComponent } from './entities/item/item-form/item-form.component';
import { ItemReactiveFormComponent } from './entities/item/item-reactive-form/item-reactive-form.component';
import { HttpRequestIntercept } from './config/interceptors/http-request-interceptor.interceptor';

import { AutoCompleteModule } from 'primeng/autocomplete';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { IdentificationComponent } from './authentication/identification/identification.component';
import { RegisterComponent } from './authentication/register/register.component';
import { FavouriteItemsListComponent } from './entities/item/favourite-items-list/favourite-items-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    CategoryListComponent,
    CategoryFormComponent,
    ItemListComponent,
    ItemFormComponent,
    ItemReactiveFormComponent,
    IdentificationComponent,
    RegisterComponent,
    FavouriteItemsListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AutoCompleteModule,
    ToastModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpRequestIntercept,
      multi: true
    },
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
