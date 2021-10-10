<template>
  <b-container>
    <b-row class="mt-2 mb-2">
      <canvas class="m-3" ref="pieChart" width="900px" height="250px"></canvas>
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
    await new Chart(this.$refs.pieChart, {
      type: 'pie',
      data: {
        labels: ["Man", "Woman"],
        datasets: [
        {
            label: '가입자 성별',
            borderColor: 'rgba(245, 229, 27, 1)',
            // backgroundColor: 'rgba(144,238,144 , 0.9 )',
            backgroundColor: [this.label, this.label.Woman, "#00D8FF"],
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
    // this.gradient = this.$refs.canvas
    //   .getContext("2d")
    //   .createLinearGradient(0, 0, 0, 450);
    // this.gradient2 = this.$refs.canvas
    //   .getContext("2d")
    //   .createLinearGradient(0, 0, 0, 450);

    // this.gradient.addColorStop(0, "rgba(255, 0,0, 0.5)");
    // this.gradient.addColorStop(0.5, "rgba(255, 0, 0, 0.25)");
    // this.gradient.addColorStop(1, "rgba(255, 0, 0, 0)");

    // this.gradient2.addColorStop(0, "rgba(0, 231, 255, 0.9)");
    // this.gradient2.addColorStop(0.5, "rgba(0, 231, 255, 0.25)");
    // this.gradient2.addColorStop(1, "rgba(0, 231, 255, 0)");
    // this.renderChart(
    //   {
    //     labels: ["Man", "Woman"],
    //     datasets: [
    //       {
    //         backgroundColor: [this.gradient, this.gradient2, "#00D8FF"],
    //         data: [40, 20, 10]
    //       }
    //     ]
    //   },
    //   { responsive: true, maintainAspectRatio: false }
    // );
</script>