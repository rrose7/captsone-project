import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Author} from "../../../../models/author";
import {categories} from "../../../../models/categories.model";

@Component({
  selector: 'app-edit-author',
  templateUrl: './edit-author.component.html',
  styleUrls: ['./edit-author.component.css']
})
export class EditAuthorComponent implements OnInit {

  @Input('author') author: Author;

  @Input('categories') categories: categories[];

  @Output() updateAuthor = new EventEmitter();
  @Output() cancelEvent = new EventEmitter();

  dropdownSettings = {};

  constructor() {
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true,
      ngModelOptions: {
        standalone: true
      }
    };
  }

  ngOnInit() {
  }

  submit() {
    this.updateAuthor.next();
  }

  cancel() {
    this.cancelEvent.next();
  }

}
