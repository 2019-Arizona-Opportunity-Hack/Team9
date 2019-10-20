import { Component, OnInit } from '@angular/core';
import { Service } from 'src/models/service';
import * as fileSaver from 'file-saver';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-report-dates-selector',
  templateUrl: './report-dates-selector.component.html',
  styleUrls: ['./report-dates-selector.component.scss']
})
export class ReportDatesSelectorComponent implements OnInit {
  selectedService: Service;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.selectedService = JSON.parse(sessionStorage.getItem('selectedReportService'));
  }

  onGenerate() {
    let headers = new HttpHeaders();
    headers = headers.append('Accept', 'text/csv; charset=utf-8');

    this.http.get('/assets/data/export-201910201228.csv', {
      headers,
      observe: 'response',
      responseType: 'text'
    }).subscribe(response => {
      const filename = response.headers.get('filename');

      this.saveFile(response.body, filename);
    });
  }

  saveFile(data: any, filename?: string) {
    const blob = new Blob([data], {type: 'text/csv; charset=utf-8'});
    fileSaver.saveAs(blob, filename);
  }
}
