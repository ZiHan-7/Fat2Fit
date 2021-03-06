import { Component, OnInit } from '@angular/core';
import { ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  public lineChartData: ChartDataSets[] = [
    { data: [null, 20, 30], label: 'Series 1' },
    { data: [5, 30, 15], label: 'Series 2' },
  ];
  public lineChartLabels: Label[] = ['Jan', 'Feb', 'Mar','Apr', 'May', 'Jun','Jul', 'Aug', 'Sep','Oct', 'Nov', 'Dec']
  public lineChartLegend = true;
  public lineChartType = 'line';
  public chartOption = {
    responsive: true,
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true
          }
        }
      ]
    }
  }

  constructor() { }

  ngOnInit() {
  }

}
