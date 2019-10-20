import { Component, OnInit } from '@angular/core';
import { Service } from 'src/models/service';

@Component({
  selector: 'app-report-dates-selector',
  templateUrl: './report-dates-selector.component.html',
  styleUrls: ['./report-dates-selector.component.scss']
})
export class ReportDatesSelectorComponent implements OnInit {
  selectedService;
  constructor() { }

  ngOnInit() {
    this.selectedService = JSON.parse(sessionStorage.getItem('selectedReportService'));
    console.log(this.selectedService);
  }

}
