import { Component, Input, OnInit } from '@angular/core';
import { ISong } from '../types/song';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

  constructor() { }

  @Input() song!: ISong;

  ngOnInit(): void {
  }
}
