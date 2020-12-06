import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  @Output() toogleSideBar = new EventEmitter();
  constructor() {}
  ngOnInit(): void {}
  handleToogleSideBar(): void {
    this.toogleSideBar.emit();
  }
}
