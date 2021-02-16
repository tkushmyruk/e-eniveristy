<#import "common/common.ftlh" as com>
<@com.main>
<h2>${faculty.facultyName}</h2>
    <div>You can redact information about faculty</div>
    <form method="post">
        <div><label>Name : <input type="text" name="facultyName" value="${faculty.facultyName}"> </label></div>
        <div><label>Free Places : <input type="number" name="freePlaces" value="${faculty.freePlaces}"> </label></div>
        <div><label>ScholarshipPlaces : <input type="text" name="scholarshipPlaces" value="${faculty.scholarshipPlaces}"> </label></div>
        <div>
            <div>Add new disciplies and split it by ';'</div>
            <label>Disciplines : <input type="text" name="disciplines"> </label>
        </div>
        <div>Set hulls address</div>
        <div><label>City : <input type="text" name="city"> </label></div>
        <div><label>Street : <input type="text" name="street"> </label></div>
        <div><label>Building : <input type="text" name="building"> </label></div>
        <button type="submit">Add new Faculty</button>
    </form>
</@com.main>