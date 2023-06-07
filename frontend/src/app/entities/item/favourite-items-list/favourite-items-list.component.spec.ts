import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavouriteItemsListComponent } from './favourite-items-list.component';

describe('FavouriteItemsListComponent', () => {
  let component: FavouriteItemsListComponent;
  let fixture: ComponentFixture<FavouriteItemsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FavouriteItemsListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FavouriteItemsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
