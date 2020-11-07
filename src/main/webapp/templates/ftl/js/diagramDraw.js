
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var counts = document.getElementsByClassName("disable_field_count");
    var names = document.getElementsByClassName("disable_field_name");

    var dates = [];

    // for(let i = 0; counts.length > i; i++){
    //     var localDates = [names[i], counts[i]];
    //     dates.push(localDates);
    // }
    var dates = [];
    for(let i = 0; counts.length > i; i++){
        var localDates = [names[i].value, parseInt(counts[i].value)];
        dates.push(localDates);
    }


    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Month'); // Implicit domain label col.
    data.addColumn('number', 'Sales'); // Implicit series 1 data col.
    for(let i = 0; counts.length > i; i++){
        data.addRows([
            dates[i],
        ]);
    }



    var options = {
        title: 'Analyze my Money',
        is3D: true,
        backgroundColor: {fill: "#fbe9df",}
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
    chart.draw(data, options);
}
