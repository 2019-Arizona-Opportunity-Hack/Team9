import { Component, OnInit } from '@angular/core';
import { Service } from 'src/models/service';

@Component({
  selector: 'app-report-dates-selector',
  templateUrl: './report-dates-selector.component.html',
  styleUrls: ['./report-dates-selector.component.scss']
})
export class ReportDatesSelectorComponent implements OnInit {
  selectedService: Service;
  startDate: string;
  endDate: string;
  constructor() { }

  ngOnInit() {
    this.selectedService = JSON.parse(sessionStorage.getItem('selectedReportService'));
  }

  onGenerate() {
    console.log(this.selectedService);
    console.log(this.startDate);
    console.log(this.endDate);
  }
}
