
function getMonthPrice(){
	var jsonData = document.getElementById('json').value;
	var chartData = JSON.parse(jsonData);
	var dataArr = [];
	
	for(var i = 0; i < chartData.length ; i++){
		dataArr[i] = chartData[i].totalPrice;
	}
	
	return dataArr;
}

new Chart(document.getElementById("chart1"), {
    type: 'bar',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        datasets: [{
            label: '월매출',
/*            data: [
                10,
                3,
                30,
                23,
                10,
                5,
                50
            ],*/
            data: 
               getMonthPrice()
            ,
            borderColor: "rgba(255, 201, 14, 1)",
            backgroundColor: "rgba(128, 208, 179, 3)",
            fill: true,
            lineTension: 0
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: '매출 현황'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
             callbacks: {
          		label: function (tooltipItem, data) {
                const tooltipValue = data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index];
                return parseInt(tooltipValue, 10).toLocaleString();
              },
              }
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                }
            }],
            yAxes: [{
                display: true,
                ticks: {
                    suggestedMin: 0,
                    callback: function(value, index, ticks) {
                        return parseInt(value, 10).toLocaleString();
                    },
                },
                scaleLabel: {
                    display: true,
                },
                
            }]
            
        }
    }
});

function getYearPrice(){
	var jsonData = document.getElementById('json1').value;
	var chartData = JSON.parse(jsonData);
	var dataArr = [];
	
	for(var i = 0; i < chartData.length ; i++){
		dataArr[i] = chartData[i].totalPrice;
	}
	
	return dataArr;
}
function getYear(){
	var jsonData = document.getElementById('json1').value;
	var chartData = JSON.parse(jsonData);
	var dataArr = [];
	
	for(var i = 0; i < chartData.length ; i++){
		dataArr[i] = chartData[i].bookYear;
	}
	
	return dataArr;
}
new Chart(document.getElementById("chart2"), {
    type: 'bar',
    data: {
        labels: getYear(),
        datasets: [{
            label: '연매출',
/*            data: [
                10,
                3,
                30,
                23,
                10,
                5,
                50
            ],*/
            data: 
            getYearPrice()
            
              
            ,
            borderColor: "rgba(255, 201, 14, 1)",
            backgroundColor: "rgba(148, 203, 95, 3)",
            fill: true,
            lineTension: 0
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: '매출 현황'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                }
            }],
            yAxes: [{
                display: true,
                ticks: {
                    suggestedMin: 0,
                    callback: function(value, index, ticks) {
                        return parseInt(value, 10).toLocaleString();
                    },
                },
                scaleLabel: {
                    display: true,
                }
            }]
        }
    }
});
 