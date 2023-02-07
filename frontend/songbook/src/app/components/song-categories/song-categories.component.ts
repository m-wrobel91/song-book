import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';
import { MainCategoryService } from 'src/app/services/main-category.service';
import { ICategory } from 'src/app/types/category';
import { IMainCategory } from 'src/app/types/main-category';

@Component({
  selector: 'app-song-categories',
  templateUrl: './song-categories.component.html',
  styleUrls: ['./song-categories.component.css', '../../pure-min.css']
})
export class SongCategoriesComponent implements OnInit {

  mainCategoryList!: IMainCategory[];
  errorMessage = '';
  sub!: Subscription;


  constructor(private mainCategoryService: MainCategoryService) { }

  ngOnInit(): void {
    console.log("i am in init", this.mainCategoryList);
    this.sub = this.mainCategoryService.getMainCategories().subscribe({
      next: mainCategories => this.mainCategoryList = mainCategories,
      error: err => this.errorMessage = err
    }
    );
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
