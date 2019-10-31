import socket
import sys
from filetransfer import *
import time

HOST = str(sys.argv[1])
PORT = int(sys.argv[2])
REQUEST_TYPE = str(sys.argv[3])

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
try:
    s.connect((HOST, PORT))
except Exception as e:
    # Print the exception message
    print(e)
    # Exit with a non-zero value, to indicate an error condition
    exit(1)
print("[+] Established Connection with Server")
if(REQUEST_TYPE == "get"):
    s.sendall("put".encode('utf-8'))
    fileName = sys.argv[4].encode('utf-8')
    time.sleep(1)
    s.sendall(fileName)
    receive_file(s, "client")
elif(REQUEST_TYPE == "put"):
    s.sendall("get".encode('utf-8'))
    fileName = str(sys.argv[4])
    time.sleep(1)
    send_file(s, fileName, "client")
elif(REQUEST_TYPE == "list"):
    s.sendall(REQUEST_TYPE.encode('utf-8'))
    list_dir()
else:
    print("[!] Invalid Reqest")
s.close()
print("[-] Disconnected")
sys.exit(0)
