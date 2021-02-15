<#import "common/common.ftlh" as com>
<@com.main>
    <h2>${facultyName}</h2>
    <form method="post">
        <div><p>Education Form</p>
            <p><input name="educationForm" type="radio" value="DAY">Day</p>
            <p><input name="educationForm" type="radio" value="EVENING">Evening</p>
            <p><input name="educationForm" type="radio" value="REMOVE">Remove</p>
        </div>
    <button type="submit">Start registration student order</button>
    </form>
</@com.main>