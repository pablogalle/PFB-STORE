import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './entities/category/category-list/category-list.component';
import { ItemListComponent } from './entities/item/item-list/item-list.component';
import { ItemReactiveFormComponent } from './entities/item/item-reactive-form/item-reactive-form.component';
import { CategoryFormComponent } from './entities/category/category-form/category-form.component';
import { IdentificationComponent } from './authentication/identification/identification.component';
import { RegisterComponent } from './authentication/register/register.component';
import { FavouriteItemsListComponent } from './entities/item/favourite-items-list/favourite-items-list.component';
import { ShoppingCartListComponent } from './entities/shoppingCart/shopping-cart-list/shopping-cart-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'categories', pathMatch: 'full' },
  { path: 'categories', component: CategoryListComponent },
  { path: 'items', component: ItemListComponent },
  { path: 'categories/:categoryId/items', component: ItemListComponent },
  { path: 'favourites', component: FavouriteItemsListComponent},
  { path: 'items/:itemId', component: ItemReactiveFormComponent },
  { path: 'categories/:categoryId', component: CategoryFormComponent },
  { path: 'identification', component: IdentificationComponent },
  { path: 'identification/register', component: RegisterComponent },
  { path: 'cart', component: ShoppingCartListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
