<template>
  <b-container>
    <b-row class="mt-2 mb-2">
      <canvas class="m-3" ref="myChart" width="900px" height="250px"></canvas>
    </b-row>
  </b-container>
</template>

<script>
import Chart from 'chart.js';
export default {
  props: {
    label: {
      type: Array
    },
    chartData: {
      type: Array
    },
  },
  async mounted() {
    await new Chart(this.$refs.myChart, {
      type: 'line',
      data: {
        labels: this.label,
        datasets: [
        {
            label: '가입자',
            borderColor: 'rgba(245, 229, 27, 1)',
            backgroundColor: 'rgba(255, 236, 139,0.2)',
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
