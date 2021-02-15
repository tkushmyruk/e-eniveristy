<#import "common/common.ftlh" as com>
<@com.main>
    <br/>
    <br/>
    <h2 align="center">List of Faculties</h2>
    <h3>Redact faculty</h3>
    <form method="post" action="/faculties/redaction">
    <div>
        <#list faculties as faculty>
            <div>
              <div><label>Faculty name: <input type="text" name="facultyName" value="${faculty.facultyName}"></label></div>
            </div>
        </#list>
    </div>
    </form>
    <form method="post" action="/faculties/redaction">
        <div><label>Name : <input type="text" name="facultyName"> </label></div>
        <div><label>Free Places : <input type="number" name="freePlaces"> </label></div>
        <div><label>ScholarshipPlaces : <input type="text" name="scholarshipPlaces"> </label></div>
        <div>
            <div>Please input required disciplies and split it by ';'</div>
            <label>Disciplines : <input type="text" name="disciplines"> </label>
        </div>
        <div>Set hulls address</div>
        <div><label>City : <input type="text" name="city"> </label></div>
        <div><label>Street : <input type="text" name="street"> </label></div>
        <div><label>Building : <input type="text" name="building"> </label></div>
        <button type="submit">Add new Faculty</button>
    </form>
</@com.main>