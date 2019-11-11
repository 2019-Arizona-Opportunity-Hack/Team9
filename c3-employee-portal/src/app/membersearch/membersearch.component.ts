import { Component, OnInit } from '@angular/core';
import { Member } from 'src/models/member';
import { C3ApiService } from '../c3-api.service';

@Component({
  selector: 'app-membersearch',
  templateUrl: './membersearch.component.html',
  styleUrls: ['./membersearch.component.scss']
})
export class MembersearchComponent implements OnInit {
  lastName = '';
  dateOfBirth = '';
  phoneNumber = '';
  results;

  constructor(private c3services: C3ApiService) { }

  ngOnInit() {
  }

  public memberSearch() {
    this.c3services.getFamilies(this.lastName, this.dateOfBirth, this.phoneNumber).subscribe(families => this.results = families);

    console.log(this.results);
  }

}
