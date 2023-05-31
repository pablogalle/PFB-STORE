import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './entities/category/category-list/category-list.component';
import { ItemListComponent } from './entities/item/item-list/item-list.component';
import { ItemFormComponent } from './entities/item/item-form/item-form.component';
import { ItemReactiveFormComponent } from './entities/item/item-reactive-form/item-reactive-form.component';
import { CategoryFormComponent } from './entities/category/category-form/category-form.component';
import { IdentificationComponent } from './authentication/identification/identification.component';
import { RegisterComponent } from './authentication/register/register.component';

const routes: Routes = [
  { path: '', redirectTo: 'categories', pathMatch: 'full' },
  { path: 'categories', component: CategoryListComponent },
  { path: 'items', component: ItemListComponent },
  { path: 'categories/:categoryId/items', component: ItemListComponent },
  { path: 'items/:itemId', component: ItemReactiveFormComponent },
  { path: 'categories/:categoryId', component: CategoryFormComponent },
  { path: 'identification', component: IdentificationComponent },
  { path: 'identification/register', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
