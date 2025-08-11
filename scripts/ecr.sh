aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 788269088007.dkr.ecr.us-east-1.amazonaws.com
docker build -t wl-perfect-number .
docker tag wl-perfect-number:1.0.0 788269088007.dkr.ecr.us-east-1.amazonaws.com/wl-perfect-number:1.0.0
docker push 788269088007.dkr.ecr.us-east-1.amazonaws.com/wl-perfect-number:1.0.0