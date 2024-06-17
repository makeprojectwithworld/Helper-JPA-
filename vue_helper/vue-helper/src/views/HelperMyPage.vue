<template>
  <HelperHeader/>
  <div class="my-page">
    <div class="profile-header">
      <div class="profile-info">
        <h1>{{ user.nickname }}</h1>
        <div class="profile-stats">
          <div class="stat">
            <span>트레이너 인증</span>
            <span><font-awesome-icon :icon="['fas', 'certificate']" /></span>
          </div>
          <div class="stat">
            <span>보조 점수</span>
            <span>{{ user.assistScore }}</span>
          </div>
          <div class="stat">
            <span>도움 점수</span>
            <span>{{ user.helpScore }}</span>
          </div>
          <span class="gym">SSAFY GYM</span>
        </div>
      </div>
    </div>
    <div class="exercise-records">
      <div class="exercise">
        <div class="exercise-icon">
          <img src="@/assets/HelperMyPage_Img/my_1.png" alt="my_1">
        </div>
        <span>벤치프레스</span>
        <span>100Kg</span>
      </div>
      <div class="exercise">
        <div class="exercise-icon">
          <img src="@/assets/HelperMyPage_Img/my_2.png" alt="my_2">
        </div>
        <span>스쿼트</span>
        <span>100Kg</span>
      </div>
      <div class="exercise">
        <div class="exercise-icon">
          <img src="@/assets/HelperMyPage_Img/my_3.png" alt="my_3">
        </div>
        <span>데드리프트</span>
        <span>100Kg</span>
      </div>
    </div>
    <div class="activity-heatmap">
      <h2>운동기록</h2>
      <div id="heatmap"></div>
    </div>
  </div>
</template>

<script>
import HelperHeader from '@/components/HelperHeader.vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import * as d3 from 'd3';

export default {
  name: 'HelperMyPage',
  components: {
    FontAwesomeIcon,
    HelperHeader
  },
  data() {
    return {
      user: {
        nickname: 'SSAFY',
        assistScore: 94,
        helpScore: 100
      }
    };
  },
  mounted() {
    this.renderHeatmap();
  },
  beforeDestroy() {
    d3.select('#heatmap').selectAll('*').remove();
  },
  methods: {
    renderHeatmap() {
      // 기존 SVG 요소를 제거합니다.
      d3.select('#heatmap').selectAll('*').remove();

      const data = this.generateSampleData(); // Replace this with your actual data source
      const width = 800;
      const height = 150;
      const cellSize = 15;
      const cellPadding = 3;
      const margin = { top: 20, right: 20, bottom: 20, left: 40 };

      const svg = d3.select('#heatmap')
        .append('svg')
        .attr('width', width + margin.left + margin.right)
        .attr('height', height + margin.top + margin.bottom)
        .append('g')
        .attr('transform', `translate(${margin.left}, ${margin.top})`);

      const cellColor = '#68B984';  // Use a fixed color

      // Draw the heatmap cells with padding and a fixed color for cells with value
      svg.selectAll('rect')
        .data(data)
        .enter()
        .append('rect')
        .attr('x', d => d.week * (cellSize + cellPadding))
        .attr('y', d => d.day * (cellSize + cellPadding))
        .attr('width', cellSize)
        .attr('height', cellSize)
        .attr('fill', d => d.value > 0 ? cellColor : '#f1f3f5'); // Fill color if value > 0, otherwise light grey

      // Add month labels at the top
      const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
      svg.selectAll('.month-label')
        .data(months)
        .enter()
        .append('text')
        .attr('class', 'month-label')
        .attr('x', (d, i) => i * ((width - margin.left - margin.right) / 12) + (cellSize + cellPadding) * 2)
        .attr('y', -5)
        .attr('text-anchor', 'middle')
        .text(d => d);

      // Add day labels on the left (only once)
      const days = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
      svg.selectAll('.day-label')
        .data(days)
        .enter()
        .append('text')
        .attr('class', 'day-label')
        .attr('x', -10)
        .attr('y', (d, i) => i * (cellSize + cellPadding) + (cellSize + cellPadding) / 2)
        .attr('text-anchor', 'end')
        .text(d => d);
    },
    generateSampleData() {
      const data = [];
      for (let week = 0; week < 52; week++) {
        for (let day = 0; day < 7; day++) {
          // Randomly assign a value to some days
          const value = Math.random() > 0.7 ? Math.floor(Math.random() * 10) : 0; // 30% chance to have a value
          data.push({
            week,
            day,
            value
          });
        }
      }
      return data;
    }
  }
};
</script>

<style scoped>
.my-page {
  max-width: 1200px;
  margin: 20px auto;
  padding: 20px;
  background: white;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.logo {
  display: inline;
}

.highlight-text {
  background: linear-gradient(to top, aquamarine 10%, transparent 30%);
  font-size: 36px;
  font-weight: 700;
  text-decoration: none;
  color: #4e4e4e;
}

.gohome {
  text-decoration: none;
}

.gym {
  background-color: lightgrey;
  padding: 5px;
  color: white;
  border: none;
  margin-left: auto; /* Move the gym name to the right */
}

.profile-header {
  border-bottom: 1px solid #ddd;
  padding-bottom: 20px;
  margin-bottom: 20px;
  display: flex;
  align-items: center;
  border-radius: 0px;
}

.profile-info {
  display: flex;
  align-items: center;
  width: 100%;
  justify-content: space-between; /* Ensure items are distributed evenly */
}

.profile-info h1 {
  font-size: 36px;
  margin-right: 20px;
  flex-shrink: 0; /* Prevent nickname from shrinking */
  color: #4e4e4e;
}

.profile-stats {
  display: flex;
  align-items: center;
  font-size: 18px;
  gap: 30px;
  flex-grow: 1; /* Allow stats to take up remaining space */
  justify-content: flex-end; /* Align stats to the right */
}

.profile-stats .stat {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.profile-stats .stat span {
  margin-left: 5px;
}

.exercise-records {
  display: flex;
  justify-content: space-around;
  border-bottom: 1px solid #ddd;
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-radius: 0px;
}

.exercise {
  display: flex;
  flex-direction: row; /* Align icon and text in a row */
  align-items: center;
  gap: 10px; /* Add some space between icon and text */
}

.exercise span {
  margin-top: 0; /* Remove top margin */
}

.exercise-icon img {
  width: 30px;
  height: 30px;
}

.activity-heatmap {
  text-align: center;
}

.activity-heatmap h2 {
  font-size: 24px;
  margin-bottom: 20px;
}

#heatmap {
  display: flex;
  justify-content: center;
}

.month-label {
  font-size: 10px;
  fill: #555;
}

.day-label {
  font-size: 10px;
  fill: #555;
}
</style>