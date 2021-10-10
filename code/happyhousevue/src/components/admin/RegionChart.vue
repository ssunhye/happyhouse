<template>
  <b-container>
    <b-row class="mt-2 mb-2">
      <canvas class="m-3" ref="barChart" width="900px" height="250px"></canvas>
    </b-row>
  </b-container>
</template>

<script>
import Chart from 'chart.js';
export default {
  props: {
    label:  {
      type: Array
    },
    chartData:  {
      type: Array
    }
  },
  async mounted() {
    await new Chart(this.$refs.barChart, {
      type: 'bar',
      data: {
        labels: this.label,
        datasets: [
        {
            label: '사는 지역',
            backgroundColor: 'rgba(204,128,144 , 0.6 )',
            data: this.chartData,
        }
        ]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });
  }
}
</script>