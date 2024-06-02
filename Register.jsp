<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title>Registration Form</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center min-vh-100">
		<div class="row w-100 justify-content-center">
			<div class="col-md-6 col-lg-5">
				<form class="form" action="regForm" onsubmit="return validation()" method="post">
					<p class="title">Register</p>
					<p class="message">Signup now and get full access to our app.</p>
					<div class="row">
						<div class="col">
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="firstname" name="user" placeholder="Firstname" required> 
								<label for="firstname">Firstname</label>
							</div>
						</div>
						<div class="col">
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="lastname" placeholder="Lastname" name="lname" required> 
								<label for="lastname">Lastname</label>
							</div>
						</div>
					</div>
					<div class="form-floating mb-3">
						<input type="email" class="form-control" name="email" id="email" placeholder="Email" required> 
						<label for="email">Email</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="password" name="pass" placeholder="Password" required> 
						<label for="password">Password</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="confirm-password" name="cnf" placeholder="Confirm password" required> 
						<label for="confirm-password">Confirm password</label>
					</div>
					<button type="submit" class="btn btn-primary w-100 submit">Submit</button>
					<p class="signin">
						Already have an account? <a href="#">Signin</a>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
