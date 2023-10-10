<html lang="en">
<#include "base.ftl">

<#macro title>Weather input page</#macro>
<#macro header>Weather input page</#macro>

<head>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        $(document).on("click", "#ajax-button", function () {
            let city = $("#city-input").val();
            $.get("/weather?city=" + city, function (response) {
                $("#ajax-response").text(response);
            });

        })
    </script>
</head>

<#macro content>
    Hello, please enter the city name you want to get forecast for
    <br>
    <form>
        CITY:
            <input type="text" id="city-input" name="cityName" />
            <input type="button" id="ajax-button" value="ok" />
    </form>

    <div id="ajax-response">

    </div>
</#macro>

</html>