import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongCategoriesComponent } from './song-categories.component';

describe('SongCategoriesComponent', () => {
  let component: SongCategoriesComponent;
  let fixture: ComponentFixture<SongCategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SongCategoriesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
