import { Component, OnInit } from '@angular/core';
import { faMusic } from '@fortawesome/free-solid-svg-icons';
import { faFacebook, faInstagram } from '@fortawesome/free-brands-svg-icons';



@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css', '../../pure-min.css']
})
export class FooterComponent implements OnInit {

  faMusic = faMusic;
  faFacebook = faFacebook;
  faInstagram= faInstagram;

  constructor() { }

  ngOnInit(): void {
  }

}
