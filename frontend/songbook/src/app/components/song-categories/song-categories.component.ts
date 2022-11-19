import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';
import { ICategory } from 'src/app/types/category';

@Component({
  selector: 'app-song-categories',
  templateUrl: './song-categories.component.html',
  styleUrls: ['./song-categories.component.css', '../../pure-min.css']
})
export class SongCategoriesComponent implements OnInit {

  categoryList!: ICategory[];
  errorMessage = '';
  sub!: Subscription;


  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    console.log("i am in init", this.categoryList);
    this.sub= this.categoryService.getCategories().subscribe({
        next: categories => this.categoryList = categories,
        error: err => this.errorMessage = err }
    );
}

ngOnDestroy(): void{
    this.sub.unsubscribe();
}

}
